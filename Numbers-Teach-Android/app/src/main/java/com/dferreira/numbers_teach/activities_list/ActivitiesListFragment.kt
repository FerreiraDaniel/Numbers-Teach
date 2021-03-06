package com.dferreira.numbers_teach.activities_list

import android.os.Bundle
import android.view.*
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.dferreira.numbers_teach.R
import com.dferreira.numbers_teach.exercise_icons.ui.menu_item_to_exercise_type_converter.IMenuItemToExerciseTypeConverter
import com.dferreira.numbers_teach.exercise_icons.ui.menu_item_to_exercise_type_converter.MenuItemToExerciseTypeConverter
import com.dferreira.numbers_teach.generic.ui.ILanguageActivity
import com.dferreira.numbers_teach.select_images_exercise.SelectImagesExerciseActivity

/**
 * Show a list of possible activities that the user could take to learn the numbers in the
 * chosen language
 */
class ActivitiesListFragment : Fragment() {
    private lateinit var listOfActivities: ListView
    private var activitiesListAdapter: ActivitiesListAdapter? = null
    private lateinit var menuItemToExerciseTypeConverter: IMenuItemToExerciseTypeConverter

    /**
     * Create of inflate  the Fragment's UI, and return it.
     *
     * @param inflater           Responsible for inflating the view
     * @param container          container where the fragment is going to be included
     * @param savedInstanceState bundle with data that was saved in on save instance if any
     * @return view of fragment of the list of activities available to the user
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        menuItemToExerciseTypeConverter = MenuItemToExerciseTypeConverter()
        return inflater.inflate(R.layout.activities_list_fragment, container, false)
    }

    /**
     * Bind the the views to the respective variables
     */
    private fun bindViews(view: View) {
        listOfActivities = view.findViewById(R.id.list_of_activities)
    }

    /**
     * Set the the on click listener to be the fragment
     */
    private fun setEvents() {
        val currentActivity = requireActivity()
        val language = languagePrefix()

        activitiesListAdapter = ActivitiesListAdapter(currentActivity, language)
        listOfActivities.adapter = activitiesListAdapter
    }

    /**
     * @param savedInstanceState bundle with data that was saved in on save instance if any
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.setHasOptionsMenu(true)
        bindViews(view)
        setEvents()
    }

    /**
     * Inflates the existing menu
     *
     * @param menu         Menu to be inflated
     * @param menuInflater Inflater of the menu
     */
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        activitiesListAdapter!!.setMenu(menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    /**
     * Called whe one item in the menu is clicked
     *
     * @param item The item of the menu that was clicked
     * @return if the event was not handled
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        val language = languagePrefix()
        val exerciseType = menuItemToExerciseTypeConverter.toExerciseType(item)
        SelectImagesExerciseActivity.startSelectImagesExerciseActivity(
            requireContext(),
            language,
            exerciseType
        )
        return true
    }

    /**
     * @return The language that the user selected to learn
     */
    private fun languagePrefix(): String = (activity as ILanguageActivity).languagePrefix()
}