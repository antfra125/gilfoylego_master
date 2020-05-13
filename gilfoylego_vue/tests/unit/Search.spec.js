/*import { enableFetchMocks } from 'jest-fetch-mock'
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
    
    fetch.mockResponseOnce(JSON.stringify(mockForm))
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
    
    
    fetch.mockResponseOnce(JSON.stringify(expectedResult))
    await store.dispatch('getFormdata', expectedResult)
    
    
    expect(store.state.form).toEqual(expectedResult)
  })
})*/
