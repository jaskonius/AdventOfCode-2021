import java.io.File
import java.nio.file.Paths

fun getInput(file: String): List<String>{
    return loadFileContent(file)
}

private fun loadFileContent(file: String): List<String> {
    val filePath = Paths.get(
        ClassLoader.getSystemResource(
            "input/${file}.txt"
        ).toURI()
    ).toString()

    return File(filePath).readLines()
}
