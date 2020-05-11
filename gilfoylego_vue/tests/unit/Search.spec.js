import { enableFetchMocks } from 'jest-fetch-mock'
enableFetchMocks()

import store from '@/store/index.js'
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
  test('page is showing', () => {
    expect(component.vm.show).toEqual(true)
  })
  test('hotels is an array', () => {
    expect(component.vm.hotels).toEqual([])
  })
  test('it is possible to sort by price', () => {
    component.vm.$store = store
    store.state.sortByPrice = sortByPrice
    component.vm.sortByPrice()
    expect(sortByprice).toEqual(true)
  })
  test('it is possible to sort by rating', () => {
    component.vm.$store = store
    store.state.sortByRating = sortByRating
    component.vm.sortByRating()
    expect(sortByRating).toEqual(true)
  })
})
