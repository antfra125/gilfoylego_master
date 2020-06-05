import { enableFetchMocks } from 'jest-fetch-mock'
enableFetchMocks()

import store from '@/store/index.js'
import { shallowMount } from '@vue/test-utils'
import Registration from '@/views/Registration.vue'

describe('Registration.vue', () => {
    const component = shallowMount(Registration)

    test('is a vue component', () => {
        expect(component.isVueInstance()).toBeTruthy()
    })
    test('the form should be formatted correctly', () => {
        let expectedResult = {
            username: '',
            email: '',
            password: '',
            passwordCheck: '',
            firstName: '',
            lastName:'',
            phone:'',
            street: '',
            zipCode: '',
            city: '',
        }
        expect(component.vm.form).toEqual(expectedResult)
    })
})