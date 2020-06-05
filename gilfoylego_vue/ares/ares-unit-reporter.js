const report = require('../reports/unit-report.json');
// load ares-helper and the ares configuration
const ares = require('ares-helper');
ares.debug = true;
ares.setProjectInfo('ares-config.json');

reportToAres();

function transformFilePathToTestName(filePath){
  let name = ''
  // if the name of the test is a full path, we just want the filename, not the whole path
  if(filePath.includes('\\')){
    name = filePath.split('\\') // windows
  }else{
    name = filePath.split('/') // mac, linux, etc
  }
  name = name.pop() // keep the name (at the end of the path)
  name = name.split('.')[0] // remove any filename endings, just keep the name
  return name
}

async function reportToAres() {
  await ares.startTests();

  // a testResult = a unit testResult ≈ an ares module
  for (let testResult of report.testResults) {

    // fix, we do not execute if there is no test
    if(!testResult.assertionResults||!testResult.assertionResults.length > 0){
      break;
    }

    let moduleName = transformFilePathToTestName(testResult.name)

    await ares.startModule({
      moduleName: moduleName,
      totalTests: testResult.assertionResults.length
    });

    // assertionResult === one unit test with an assertion
    for (let assertionResult of testResult.assertionResults) {

      await ares.testResult({
        moduleName: moduleName,
        title: assertionResult.fullName,
        passed: (assertionResult.status === 'passed'),
        errorMessage: (assertionResult.failureMessages && assertionResult.failureMessages.join('\n')),
        testBrowser: 'n/a'
      });

    }
    await ares.endModule({
      moduleName: moduleName
    });
  }
  await ares.endTests()
}