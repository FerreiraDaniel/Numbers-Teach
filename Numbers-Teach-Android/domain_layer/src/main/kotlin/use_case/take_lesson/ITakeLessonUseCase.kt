package use_case.take_lesson

import presenter.ITakeLessonUIPresenter

interface ITakeLessonUseCase: ITakeLessonUIEventHandler {

    fun updateUIPresenter(uiPresenter: ITakeLessonUIPresenter?)
    fun getEventHandler(): ITakeLessonUIEventHandler
    fun startLesson()
}