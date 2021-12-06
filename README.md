# Expectations:

### `TodoActivity`
1. Reformat code to follow kotlin codestyle 
2. Add `if(savedInstanceState==null)` before fragment transaction to optimise app startup (tricky)

### `TodoFragment` and `TodoViewModel`
1. Use `RecycleView` instead of `LinearLayout`
2. Move `TodoRepository.getTodoList()` to `TodoViewModel` 
3. Inject `TodoRepository` to `TodoViewModel`
4. Rename `NAVIGATE_TO` to `navigateTo` to follow kotlin codestyle 
5. Change `MutableLiveData` to `SingleLiveData` or to some other workaround 

### `TodoItem` 
1. Use data classes instead of just classes 
2. Reformat to kotlin codestyle 
3. Add named parameters (tricky) 

### `TodoDetailsFragment`
1. Use fragment arguments for passing parameters instead of constructor 
2. Move OkHttp and api call to a Repository 

# If task is not clear, there are 2 bugs that were added intentionally that you can ask to spot and fix:
1. If you open details and then click back, you will land on details again 
2. If you rotate screen on details page app will crash 
