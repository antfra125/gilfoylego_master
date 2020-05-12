let { $, sleep } = require('./funcs');
 module.exports = function () {

   
     this.Given(/^that I am on the homepage$/, async function () {
        
         await helpers.loadPage('http://localhost:8080/');
         await sleep(2002);
         
     });
     

     this.When(/^I click the account button$/, async function () {
         let profilbutton = await driver.findElement(by.css('#__BVID__7'));
         profilbutton.click();
         await driver.findElement(by.css('#__BVID__7 > ul > div > li > a'));
         
         
     });


     this.When(/^I click on loggin in the dropdown menu$/, async function () {
         let logginButton = await driver.findElement(by.css('#__BVID__7 > ul > div > li > a'));
         logginButton.click();
         await driver.findElement(by.css('#__BVID__11'));
         
     });


     this.When(/^I click on the username field$/, async function () {
         //let usernameFiled = await driver.findElement(by.css('#__BVID__11'));
         //usernameFiled.click();
         sendKeys(keys.TAB);
         snedKeys(keys.TAB);
         sendKeys(keys.TAB); 
         await sleep(2000);
     });


     this.When(/^I enter the username "([^"]*)"$/, async function () {
        
        usernameFiled.sendText(username);

     });


     this.When(/^I click on the password field$/, async function () {
         
     });

    
    
     this.When(/^I enter the password "([^"]*)"$/, async function () {
         
     });



     this.When(/^I click the "([^"]*)" button$/, async function () {
             
     });


     this.Then(/^I should be "([^"]*)"$/, async function () {
             
     });

} 