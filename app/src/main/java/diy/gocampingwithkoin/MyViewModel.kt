package diy.gocampingwithkoin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import diy.camping_model.Item
import kotlinx.coroutines.launch

class MyViewModel (private val repository: Repository) : ViewModel(){

    private val _items = MutableLiveData<List<Item?>?>()
    val items: LiveData<List<Item?>?> get() = _items

    fun itemsFromApi(numOfRows:Int, pageNo:Int){
        viewModelScope.launch{
            _items.value = repository.getGoCampingApiService(numOfRows,pageNo)
        }
    }
}