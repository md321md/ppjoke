package com.zz.ppjoke.utils

import com.zz.ppjoke.JokeApplication
import com.zz.ppjoke.model.Destination
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun getDestConfig(): HashMap<String, Destination> {
    // 解析xml
    val content = parseFile("destination.json")
    // fastjson转换有点问题 所以改用gson
//    val parseObject =
//        JSON.parseObject(content, object : TypeReference<HashMap<String, Any>>() {})
    return Gson().fromJson(content, object : TypeToken<HashMap<String?, Destination?>?>() {}.type)
}

// 读取文件解析文件
private fun parseFile1(fileName: String): String {
    val fileJson = getApplication()?.let {
        val assets = it.resources.assets
        val stringBuilder: StringBuilder = StringBuilder()
        val stream: InputStream = assets.open(fileName)
        BufferedReader(InputStreamReader(stream)).use {
            var line: String?
            while (true) {
                line = readLine()
                if (line == null) break
                stringBuilder.append(line)
            }
        }
        stringBuilder.toString()
    }
    return fileJson ?: ""
}

private fun parseFile(fileName: String): String {
    var fileJson = ""
    val application = JokeApplication.application
    val stringBuilder: StringBuilder = StringBuilder()
    val assets = application.resources.assets
    val stream: InputStream = assets.open(fileName)
    val bufferedReader = BufferedReader(InputStreamReader(stream))
    var line: String?
    while (true) {
        line = bufferedReader.readLine()
        if (line == null) break
        stringBuilder.append(line)
    }
    bufferedReader.close()
    fileJson = stringBuilder.toString()
    return fileJson
}

