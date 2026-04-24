*** Settings ***
Library     SeleniumLibrary

*** Keywords ***
Type Into Input
    [Arguments]     ${id}       ${text}
    # Standard way to type text using ID
    Input Text      id:${id}    ${text}

Press Enter Key
    # Press Enter on password field
    Press Keys      id:password        ENTER 

Show Error Message
    # Get error text and print to console
    ${error}=       Get Text    tag:h3
    Log To Console      Error found: ${error}
    Sleep               2

Login Flow
    [Arguments]     ${user}     ${pass}
    Type Into Input     user-name     ${user}
    Type Into Input     password      ${pass}
    Press Enter Key
    Reload Page

*** Test Cases ***
SauceDemo Shopping Test
    # 1. Open Website
    Open Browser        https://www.saucedemo.com/    Chrome
    Maximize Browser Window
    
    # 2. Test Login
    Login Flow      standard_user      secret_sauce
    
    # 3. Add items to cart using Loop
    @{items}=       Create List    add-to-cart-sauce-labs-backpack    add-to-cart-sauce-labs-bike-light
    FOR  ${btn}    IN  @{items}
        Click Button        id:${btn}
    END

    # 4. Checkout Process
    Click Element       class:shopping_cart_link
    Click Element       id:checkout
    Input Text          id:first-name      QA
    Input Text          id:last-name       Engineer
    Input Text          id:postal-code     112233
    Click Button        id:continue
    Click Button        id:finish
    
    # 5. Check Success Message
    ${msg}=     Get Text    tag:h2
    Log To Console      Status: ${msg}
    Close Browser

