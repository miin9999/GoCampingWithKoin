package diy.gocampingwithkoin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import diy.gocampingwithkoin.Repository.BaseInfoRepository
import diy.gocampingwithkoin.model.camping_model.baseListModel.Item
import kotlinx.coroutines.launch

class BaseInfoViewModel (private val baseInfoRepository: BaseInfoRepository) : ViewModel(){

    private val _baseInfoItems = MutableLiveData<List<Item?>?>()

    val baseInfoItems: LiveData<List<Item?>?> get() = _baseInfoItems


    fun baseItemsFromApi(numOfRows:Int, pageNo:Int){
        viewModelScope.launch{
            _baseInfoItems.value = baseInfoRepository.getGoCampingApiService(numOfRows,pageNo)
        }
    }

}