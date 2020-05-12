import { enableFetchMocks } from 'jest-fetch-mock'
enableFetchMocks()

import store from '@/store/index.js'
import { shallowMount } from '@vue/test-utils'
import Search from '@/views/Search.vue'

describe('Search-function', () => {

  let mockForm = { 
    amenities: [],
    amountOfRooms: "",
    endDate: "",
    m2Beach: "",
    m2Center: "",
    search: "",
    startDate: ""
    }
  test('fetching the form', async () => {
  
    fetch.mockResponseOnce(mockForm)
    await store.dispatch('getFormdata')
    expect(store.state.form).toEqual(mockForm)
  })
  test('entering search data', async () => {
    let expectedResult = {
      amenities: [],
      amountOfRooms: "",
      endDate: "",
      m2Beach: "1000",
      m2Center: "200",
      search: "Sverige",
      startDate: ""
    }
    
    fetch.mockResponseOnce(mockForm)
    await store.dispatch('getFormdata')
    store.dispatch('SET_FORM', expectedResult)
    expect(store.state.form).toEqual(expectedResult)
  })
})
