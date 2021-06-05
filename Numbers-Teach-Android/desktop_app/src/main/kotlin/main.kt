import androidx.compose.desktop.Window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import use_case.take_lesson.TakeLessonUseCase

fun main() = Window {
    val takeLessonUseCase = TakeLessonUseCase()
    val windowTest = WindowTest()
    takeLessonUseCase.updateUIPresenter(windowTest)
    windowTest.setEventsHandler(takeLessonUseCase.getEventHandler())
    GlobalScope.launch {
        delay(2000)

        takeLessonUseCase.startLesson()

    }


    windowTest.mainUiLayer()
}