*** Settings ***
Library         SeleniumLibrary

*** Variables ***
${URL}          https://testautomationpractice.blogspot.com/

*** Test Cases ***
UI Elements Test
    # 1. Start Browser
    Open Browser        ${URL}      Chrome
    Maximize Browser Window

    # 2. Text Input and Radio Buttons
    Input Text          id:name     Tester
    Click Element       id:male
    
    # 3. Multiple Checkboxes (Days)
    @{days}=            Create List     sunday    monday    friday
    FOR    ${day}    IN    @{days}
        Click Element    id:${day}
    END

    # 4. Dropdown Selection
    Select From List By Label    id:country    Australia

    # 5. Handle Alert (Pop-up)
    Click Button        id:alertBtn
    Handle Alert        accept

    # 6. File Upload
    # Note: Put your image path below
    # Choose File      id:singleFileInput      C:\\your_image.png

    # 7. Read Table Data
    @{rows}=           Get Webelements     //*[@id="rows"]/tr
    FOR   ${row}    IN    @{rows}
        ${data}=       Get Text       ${row}
        Log To Console      Table Data: ${data}
    END

    # 8. Drag and Drop
    Drag And Drop      id:draggable    id:droppable

    Sleep    5
    Close Browser
bash

pip install robotframework-seleniumlibrary
robot SauceDemo.robot
robot UIPractice.robot
