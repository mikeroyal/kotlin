package org.jetbrains.kotlin.compilerRunner

import org.gradle.api.Project
import org.jetbrains.kotlin.daemon.common.impls.CompilationResultCategory
import org.jetbrains.kotlin.daemon.common.impls.CompilationResults
import org.jetbrains.kotlin.daemon.common.impls.LoopbackNetworkInterface
import org.jetbrains.kotlin.daemon.common.impls.SOCKET_ANY_FREE_PORT
import org.jetbrains.kotlin.gradle.plugin.kotlinDebug
import org.jetbrains.kotlin.daemon.report.CompileIterationResult
import org.jetbrains.kotlin.gradle.utils.pathsAsStringRelativeTo
import java.io.File
import java.io.Serializable
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

internal class GradleCompilationResults(
    private val log: KotlinLogger,
    private val projectRootFile: File
) : CompilationResults,
    UnicastRemoteObject(
        SOCKET_ANY_FREE_PORT,
        LoopbackNetworkInterface.clientLoopbackSocketFactory,
        LoopbackNetworkInterface.serverLoopbackSocketFactory
    ) {
    @Throws(RemoteException::class)
    override fun add(compilationResultCategory: Int, value: Serializable) {
        if (compilationResultCategory == CompilationResultCategory.IC_COMPILE_ITERATION.code) {
            @Suppress("UNCHECKED_CAST")
            val compileIterationResult = value as? CompileIterationResult
            if (compileIterationResult != null) {
                val sourceFiles = compileIterationResult.sourceFiles
                if (sourceFiles.any()) {
                    log.kotlinDebug { "compile iteration: ${sourceFiles.pathsAsStringRelativeTo(projectRootFile)}" }
                }
                val exitCode = compileIterationResult.exitCode
                log.kotlinDebug { "compiler exit code: $exitCode" }
            }
        }
    }
}