package ru.y

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertTrue

class AesTaskCommandTest {

    @Test
    void testWithCommandLineOption() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.out = new PrintStream(baos)
        ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

        String[] args = ["-v"] as String[]
        PicocliRunner.run(AesTaskCommand, ctx, args)

        // AesTask
        assertTrue(baos.toString().contains("Hi!"))

        ctx.close()
    }
}
