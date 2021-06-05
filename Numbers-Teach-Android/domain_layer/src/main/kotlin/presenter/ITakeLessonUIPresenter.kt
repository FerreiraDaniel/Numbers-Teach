package presenter

import use_case.take_lesson.ITakeLessonUIEventHandler

interface ITakeLessonUIPresenter {
    fun showLessonScreen()

    fun setEventsHandler(eventHandler: ITakeLessonUIEventHandler)
}