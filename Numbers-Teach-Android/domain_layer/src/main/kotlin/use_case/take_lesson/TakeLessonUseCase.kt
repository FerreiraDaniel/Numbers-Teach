package use_case.take_lesson

import presenter.ITakeLessonUIPresenter

public class TakeLessonUseCase: ITakeLessonUseCase {

    private var uiPresenter: ITakeLessonUIPresenter? = null


    override fun updateUIPresenter(uiPresenter: ITakeLessonUIPresenter?) {
        this.uiPresenter = uiPresenter
    }

    override fun getEventHandler(): ITakeLessonUIEventHandler {
        return this
    }


    override fun startLesson() {
        uiPresenter?.showLessonScreen()
    }
}