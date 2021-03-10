import ru.y.encryption.Aes256Class

import javax.crypto.Cipher

def byte[] readFileLineByLine(String filePath) {
    File file = new File(filePath)
    def noOfLines = 0;
    String line
    List<Byte> result = new ArrayList<Byte>()
    file.withReader { reader ->
        while ((line = reader.readLine()) != null) {
            println "${line.getBytes()}, ${line.getBytes().length}"
            result.addAll(line.getBytes())
            noOfLines++
        }
    }
    return result
}


byte[] getBytesFromFile(File inputFile) {
    return inputFile.bytes
}

def writeFileByBytes(byte[] bytes, File outputFile) {
    outbytes = bytes
}

def completeFile(File inputFile, File outputFile) {
    Byte[] ADDITIVE_BLOCK = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    List<Byte> result = new ArrayList<Byte>()
    outputFile.bytes = new byte[0]
    byte[] bytes = inputFile.bytes

    synchronized (result) {
        bytes.each { curByte ->
            result.add(curByte)
            result.addAll(ADDITIVE_BLOCK)
        }
    }

    outputFile.bytes = result as byte[]
}


Byte[] ADDITIVE_BLOCK = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]



Collection translationMap = (-128..127).collectMany{
    def result = [it as Byte]
    result.addAll(ADDITIVE_BLOCK)
    result
}

Aes256Class aes256 = new Aes256Class()

File inputFile = new File("/home/azajtsev/Projects/AesTask/src/main/resources/sample")
File outputFile = new File("/home/azajtsev/Projects/AesTask/src/main/resources/example")

completeFile(inputFile, outputFile)
println(outputFile.bytes)
println(translationMap.size())
println(aes256.makeAes(translationMap as byte[], Cipher.ENCRYPT_MODE).length)



//println(getBytesFromFile("F:\\Projects\\AesTask\\src\\main\\resources\\sample.jpg"))

//writeFileByBytes(
//        getBytesFromFile("F:\\Projects\\AesTask\\src\\main\\resources\\sample.jpg"),
//        'F:\\Projects\\AesTask\\src\\main\\resources\\example.jpg')
