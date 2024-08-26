package diy.gocampingwithkoin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import diy.gocampingwithkoin.Repository.ImageUrlRepository
import diy.gocampingwithkoin.model.camping_model.imageListModel.ImageItem
import kotlinx.coroutines.launch

class ImageUrlViewModel(private val imageUrlRepository: ImageUrlRepository) : ViewModel(){

    private val _imageListItems = MutableLiveData<List<ImageItem?>?>()
    val imageListItems: LiveData<List<ImageItem?>?> get() = _imageListItems

    fun imageItemsFromApi(numOfRows:Int, pageNo:Int,contentId:Int){
        viewModelScope.launch{
            _imageListItems.value = imageUrlRepository.getCampingImageApiService(numOfRows, pageNo,contentId)

        }
    }

}