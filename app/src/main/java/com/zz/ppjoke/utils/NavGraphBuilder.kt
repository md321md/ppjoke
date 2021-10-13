package com.zz.ppjoke.utils

import android.content.ComponentName
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphNavigator
import androidx.navigation.fragment.FragmentNavigator
import com.zz.ppjoke.model.Destination

// 构建页面导航结构图
class NavGraphBuilder {
    companion object {
        fun build(controller: NavController) {
            val provider = controller.navigatorProvider
            val fragmentNavigator = provider.getNavigator(FragmentNavigator::class.java)
            val activityNavigator = provider.getNavigator(ActivityNavigator::class.java)
            val navGraph = NavGraph(NavGraphNavigator(provider))
            val destConfig: HashMap<String, Destination> = getDestConfig()
            destConfig.values.forEach {
                if (it.isFragment) {
                    val destination: FragmentNavigator.Destination =
                        fragmentNavigator.createDestination().apply {
                            className = it.clazName
                            id = it.id
                            addDeepLink(it.pageUrl)
                        }
                    navGraph.addDestination(destination)
                } else {
                    val destination: ActivityNavigator.Destination =
                        activityNavigator.createDestination().apply {
                            id = it.id
                            addDeepLink(it.pageUrl)
                            setComponentName(
                                ComponentName(
                                    getApplication()?.packageName.toString(),
                                    it.clazName
                                )
                            )
                        }
                    navGraph.addDestination(destination)
                }
                if (it.asStarter) {
                    navGraph.startDestination = it.id
                }
            }
            controller.graph = navGraph
        }
    }
}