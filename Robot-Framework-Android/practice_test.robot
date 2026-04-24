*** Settings ***
Documentation    Basic Android Mobile Test
Library          AppiumLibrary
Suite Setup      Start App

*** Variables ***
${SERVER}             http://127.0.0.1:4723
${PLATFORM}           Android
${DEVICE}             Android Emulator 

*** Keywords ***
Start App
    # To open the mobile application
    Open Application         ${SERVER}
    ...                      platformName=${PLATFORM}
    ...                      deviceName=${DEVICE}
    Log To Console           App is opened.

*** Test Cases ***
Login Test
    # Click login button
    Click Element       accessibility_id=Login

    ${name_box}       set Variable       //android.widget.EditText[1]
    ${pass_box}       set Variable       //android.widget.EditText[2]

    # Type username and password
    Input Text           ${name_box}     zinzin 
    Input Text           ${pass_box}     pwd
    Sleep               2

    # Clear text and check error
    Clear Text           ${name_box}
    Clear Text           ${pass_box}
    Click Element       xpath=//android.widget.Button[@content-desc="Login"]

    # Show error messages in console
    @{errors}       Get WebElements     xpath=//android.view.View[contains(@content-desc,"username")]
    FOR      ${e}    IN  @{errors}
            ${text}=     Get Element Attribute   ${e}    content-desc
            Log To Console        Error: ${text}
    END
    Click Element       accessibility_id=Back

Date and Time Test
    # Pick a date and time
    Click Element       accessibility_id=Date & Time
    Click Element       accessibility_id=Select Date
    Input Text          xpath=//android.widget.EditText        03/15/2026
    Click Element       accessibility_id=OK
    Sleep               2
    Click Element       accessibility_id=Back

Slider Test
    # Move the slider
    Click Element           xpath= //android.view.View[@content-desc="Slider & Switch "]
    @{all_sliders}=         Get WebElements     //android.widget.SeekBar
    
    # Get location of the first slider
    ${pos}=       Get Element Location    ${all_sliders}[0] 
    ${size}=      Get Element Size        ${all_sliders}[0]
    ${x}=         Evaluate        ${pos['x']}+(${size['width']}/2)
    ${y}=         Evaluate        ${pos['y']}+(${size['height']}/2)
    
    # Use my custom swipe keyword
    Move Horizontal  ${x}  ${y}  ${pos}  ${size}  0.85
    Click Element    accessibility_id=Back 

Signature Test
    # Draw on the screen
    Click Element       accessibility_id=Signature Pad
    Swipe       start_x=300    start_y=600    end_x=350    end_y=550
    Swipe       start_x=350    start_y=550    end_x=450    end_y=550

*** Keywords ***
Move Horizontal        
    [Arguments]     ${x}    ${y}    ${pos}    ${size}    ${percent}
    # Logic to drag the slider
    ${target_x}=    Evaluate       ${pos['x']}+(${size['width']}*${percent})
    Swipe           start_x=${x}   start_y=${y}   end_x=${target_x}   end_y=${y}   
    Sleep           2
