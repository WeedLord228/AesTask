package ru.y.handlers

import ru.y.actions.PrepareAction

class PrepareActionHandler implements ActionHandler {

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

    def formTranslatioMap()
    {

    }

    def writeTranslationMap(String fileName, Map transaltionMap)
    {

    }

    @Override
    def handleAction(Object action) {
        PrepareAction prepareAction = action as PrepareAction


    }
}
