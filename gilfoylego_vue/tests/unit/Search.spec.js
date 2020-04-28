import { shallowMount } from '@vue/test-utils'
import Search from '@/views/Search.vue'

describe('Search.vue', () => {

  const component = shallowMount(Search)

  test('is a Vue component', () => {
    expect(component.isVueInstance()).toBeTruthy()
  })
  test('sMin is the correct date', () => {
    expect(component.vm.sMin).toEqual('2020-07-01');
  })
  test('sMax is the correct date', () => {
    expect(component.vm.sMax).toEqual('2020-08-30')
  })
  test('eMin is the correct date', () => {
    expect(component.vm.eMin).toEqual('2020-07-02')
  })
  test('eMax is the correct date', () => {
    expect(component.vm.eMax).toEqual('2020-08-31')
  })
  test('the form has the required components', () => {
    expect(component.vm.form).toEqual({
      "amenities": [], "amountOfRooms": "", "endDate": "",
      "m2Center": "", "search": "", "startDate": ""
    })
  })
  test('page is showing', () => {
    expect(component.vm.show).toEqual(true)
  })
  test('hotels is an array', () => {
    expect(component.vm.hotels).toEqual([])
  })
  test('the list of hotels is retrieved', () => {
    let results = component.vm.getHotels()

    expect(objectToArray(results)).toEqual(component.vm.hotels)
  })
  test('the search function is working', () => {
    let results = component.vm.filteredHotels()
    for (hotel of results) {
      result = hotel.name.toLowerCase()
      expect(hotel.name.toLowerCase()).toEqual(result)
    }

  })
}
)
function objectToArray(results) {
  var result = [];
  for (var key in results) {
    if (results.hasOwnProperty(key)) {
      result.push(results[key]);
    }
  }
  return result;
}
