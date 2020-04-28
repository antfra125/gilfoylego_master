import { shallowMount } from '@vue/test-utils'
import Search from '@/views/Search.vue'

describe('Home.vue', () => {

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
    expect(component.vm.form).toEqual({"amenities": [], "amountOfRooms": "", "endDate": "",
     "m2Center": "", "search": "", "startDate": ""})
  })
  test('page is showing', () =>{
    expect(component.vm.show).toEqual(true)
  })  
  test('hotels is an array', () => {
    expect(component.vm.hotels).toEqual([])
  })
}
)
