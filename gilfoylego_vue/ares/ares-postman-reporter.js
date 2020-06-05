const report = require('../reports/postman-report.json');
// load ares-helper and the ares configuration
const ares = require('ares-helper');
ares.debug = true;
ares.setProjectInfo('ares-config.json');

reportToAres();

async function reportToAres() {
  await ares.startTests();
  // an execution = a postman endpoint test ≈ an ares module
  for (let execution of report.run.executions) {

    // fix, we do not execute if there is no test (it lacks assertions)
    if(!execution.assertions||!execution.assertions.length > 0){
      break;
    }

    await ares.startModule({
      moduleName: execution.item.request.method + ' ' + execution.item.name, // x.run.executions[0].item.request.method + x.run.executions[0].item.name
      totalTests: execution.assertions.length
    });

    // assertion === one endpoint test assertion
    for (let assertion of execution.assertions) {

      await ares.testResult({
        moduleName: execution.item.request.method + ' ' + execution.item.name,
        title: assertion.assertion,
        passed: (assertion.error === undefined),
        errorMessage: assertion.error? assertion.error.message : '',
        testBrowser: 'n/a'
      });

    }
    await ares.endModule({
      moduleName: execution.item.request.method + ' ' + execution.item.name
    });
  }
  await ares.endTests()
}