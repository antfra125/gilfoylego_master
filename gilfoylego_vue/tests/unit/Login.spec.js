import { enableFetchMocks } from 'jest-fetch-mock'
enableFetchMocks()

import store from '@/store/index.js'
import { shallowMount } from '@vue/test-utils'
import Login from '@/views/Login.vue'



describe ('Login.vue', () => {
    const component = shallowMount(Login)

    test('is a vue component', () => {
        expect(component.isVueInstance()).toBeTruthy()
    })

    test('the form contains fields forpassword and username', () => {
        expect(component.vm.form).toEqual({
            username: "",
            password: ""
        })
    })
    test('the login is succesful', () => {
        component.vm.$store = store
        component.vm.form.username = 'admin'
        component.vm.form.password = 'admin'
        let expectedResult = {url:"/"}
        let expectedResult2 = {}
        fetch.mockResponseOnce(JSON.stringify(expectedResult)).mockResponseOnce(JSON.stringify(expectedResult2))
        component.vm.springLogin()
        expect(store.state.user).toEqual(expectedResult2)
    })
})