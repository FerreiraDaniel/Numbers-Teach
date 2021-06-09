import androidx.compose.desktop.Window
import com.dferreira.numbers_teach_ui_layer.WindowTestImpl
import com.dferreira.numbers_teach.domain_layer.use_case.take_lesson.TakeLessonUseCaseImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest


@InternalCoroutinesApi
fun main() = Window {
    val takeLessonUseCase = TakeLessonUseCaseImpl()
    val windowTest = WindowTestImpl()


    GlobalScope.launch {


        async {
            takeLessonUseCase.startLesson()
        }


        takeLessonUseCase
            .state
            .collect {state -> print("state: $state ")}

        println("out of collect")
        delay(1000)


        takeLessonUseCase
            .state
            .collect {state -> print("state: $state")}

        delay(10000)


    }

    windowTest.mainUiLayer()
}