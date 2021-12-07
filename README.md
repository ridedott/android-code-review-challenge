# Expectations:

### `TodoFragment` and `TodoViewModel`
1. Use `RecycleView` instead of `LinearLayout`
2. Move `TodoRepository.getTodoList()` to `TodoViewModel` 
3. Inject `TodoRepository` to `TodoViewModel`
4. Rename `NAVIGATE_TO` to `navigateTo` to follow kotlin codestyle 
5. Change `MutableLiveData` to `SingleLiveData` or to some other workaround 
6. Change from `lifecycleOwner` to `viewLifecycleOwner` to fix crash when user gets back from details screen

### `TodoItem | TodoListItem` 
1. Use data classes instead of just classes 
2. Reformat to kotlin codestyle

### `TodoDetailsFragment`
1. Use fragment arguments for passing parameters instead of constructor 
2. Move OkHttp and api call to a Repository
3. Create a viewModel which will provide data to Fragment
4. Would be nice to make getTodos and refresh reactive

### `TodoRepository`
1. Make it injectable 
2. Inject JSON object instead of creating it 
3. Inject OKHttp object instead of creating it 

# There are 5 bugs that were added intentionally that you can ask to spot and fix:
1. If you open details and then click back, you will land on details again 
   (This is cause by `MutableLiveData` that keeps the latest result and re-trigger navigation when you resubscribe. To fix we can clear live data when value was consumed)
2. If you rotate screen on details page app will crash 
   (There is no empty constructor for `DetailsFragment`. To fix that instead of using Fragment constructor to provide TodoId we need to use arguments)
3. If you open details screen and go back app will crash 
   (This is caused by `lifecycleOwner`, Fragment has 2 owners, one for Fragment and second for view. To fix we need to replace `lifecycleOwner` with `viewLifecycleOwner`)
4. Scroll doesn't work on todo list screen 
   (Because linear layout is not scrollable, to fix we can use recycler view)
5. App crashes if you open it without connectivity
   (Because we use !! in responses, to fix we need to check OkHttp code)

# Script
   1. Walk candidate through the app
   2. Ask whats wrong with the app? (and categorize the issue by Performance, Best-Practices, Code Styles)
   3. Run app and spot the first issue 
   4. Ask to spot and fix the second issue