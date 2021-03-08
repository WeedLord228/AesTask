package ru.y

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Parameter
import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters

@Command(name = 'aes-handler', description = '...',
        mixinStandardHelpOptions = true)
class AesTaskCommand implements Runnable {

    @Parameter()
    File file

    @Option(names = ['-p','--prepare'],arity="1" ,description = 'Расширяет указанный исходный файл с данными и создаёт файл словаря .')
    boolean prepare

    @Option(names = ['-e','--encode'],arity="1" ,description = 'Шифрует указанный расширенный файл и файл словаря AES со случайным ключом')
    boolean encode

    @Option(names = ['-d','--decode'],arity="1" ,description = 'На основании таблицы сопоставления расшифровывает наш файл с данными, после чего убирает из него расширение и словарь, если это необходимо.\n')
    boolean decode

    @Option(names = ['-t','--translate'],arity="1" ,description = 'Выводит в отдельный файл таблицу сопоставления блоков шифртекста и блоков исходного текста, основываясь на словаре\n')
    boolean translate



    static void main(String[] args) throws Exception {
        PicocliRunner.run(AesTaskCommand.class, args)
    }

    void run() {
        // business logic here
        if (prepare) {
        }

        if (encode) {
        }

        if (decode) {
        }

        if (translate) {
        }
    }
}
