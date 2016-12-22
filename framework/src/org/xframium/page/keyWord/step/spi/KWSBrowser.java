/*******************************************************************************
 * xFramium
 *
 * Copyright 2016 by Moreland Labs, Ltd. (http://www.morelandlabs.com)
 *
 * Some open source application is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 *  
 * Some open source application is distributed in the hope that it will 
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with xFramium.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 *******************************************************************************/
package org.xframium.page.keyWord.step.spi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xframium.container.SuiteContainer;
import org.xframium.device.factory.MorelandWebElement;
import org.xframium.exception.ScriptConfigurationException;
import org.xframium.exception.ScriptException;
import org.xframium.page.Page;
import org.xframium.page.data.PageData;
import org.xframium.page.element.Element;
import org.xframium.page.keyWord.step.AbstractKeyWordStep;
import org.xframium.page.keyWord.step.spi.KWSMath.MATH_TYPE;
import org.xframium.reporting.ExecutionContextTest;
import org.xframium.spi.driver.NativeDriverProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class KWSWindow.
 */
public class KWSBrowser extends AbstractKeyWordStep
{
    public KWSBrowser()
    {
        kwName = "Browser Operations";
        kwDescription = "Allows the script to work with browser windows";
        kwHelp = "https://www.xframium.org/keyword.html#kw-browser";
        orMapping = false;
        category = "Web";
    }

    /**
     * The Enum SwitchType.
     */
    public enum SwitchType
    {
        SWITCH_BY_TITLE( 1, "SWITCH_BY_TITLE", "Switch to Window with Title" ), SWITCH_BY_URL( 2, "SWITCH_BY_URL", "Switch to Window with URL" ), SWITCH_NAMED_FRAME( 3, "SWITCH_NAMED_FRAME", "Switch to Named Frame" ), SWITCH_INDEX( 4, "SWITCH_INDEX",
                "Switch to Indexed frame" ), PARENT_FRAME( 5, "PARENT_FRAME", "Switch to Parent Frame" ), DEFAULT_FRAME( 6, "DEFAULT_FRAME", "Switch to Default Window" ), CLOSE_WINDOW( 7, "CLOSE_WINDOW",
                        "Close the current window" ), SWITCH_TO_ELEMENT( 8, "SWITCH_TO_ELEMENT", "Switch to the frame by element" ), MAXIMIZE( 9, "MAXIMIZE", "Maximize the current window" ), GET_TITLE( 11, "GET_TITLE",
                                "Get the title of the current window" ), GET_URL( 12, "GET_URL", "Get the URL of the current window" ), FORWARD( 13, "FORWARD", "Click the forward button" ), BACK( 14, "BACK", "Click the back button" ), REFRESH( 15,
                                        "REFRESH", "Click the refresh button" ), NAVIGATE( 16, "NAVIGATE", "Navigate to the supplied URL" ), SWITCH_WIN_INDEX( 17, "SWITCH_WIN_INDEX", "Switch to the numbered window" ), DELETE_COOKIE( 18, "DELETE_COOKIE",
                                                "Delete the named cookie" ), GET_COOKIE( 19, "GET_COOKIE", "Switch to the numbered window" ), ADD_COOKIE( 20, "ADD_COOOKIE", "Switch to the numbered window" );

        public List<SwitchType> getSupported()
        {
            List<SwitchType> supportedList = new ArrayList<SwitchType>( 10 );
            supportedList.add( SwitchType.SWITCH_BY_TITLE );
            supportedList.add( SwitchType.SWITCH_BY_URL );
            supportedList.add( SwitchType.SWITCH_NAMED_FRAME );
            supportedList.add( SwitchType.SWITCH_INDEX );
            supportedList.add( SwitchType.PARENT_FRAME );
            supportedList.add( SwitchType.DEFAULT_FRAME );
            supportedList.add( SwitchType.CLOSE_WINDOW );
            supportedList.add( SwitchType.SWITCH_TO_ELEMENT );
            supportedList.add( SwitchType.MAXIMIZE );
            supportedList.add( SwitchType.GET_TITLE );
            supportedList.add( SwitchType.GET_URL );
            supportedList.add( SwitchType.FORWARD );
            supportedList.add( SwitchType.BACK );
            supportedList.add( SwitchType.REFRESH );
            supportedList.add( SwitchType.NAVIGATE );
            supportedList.add( SwitchType.SWITCH_WIN_INDEX );
            supportedList.add( SwitchType.DELETE_COOKIE );
            supportedList.add( SwitchType.GET_COOKIE );
            supportedList.add( SwitchType.ADD_COOKIE );
            return supportedList;
        }

        private SwitchType( int id, String name, String description )
        {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        private int id;
        private String name;
        private String description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.perfectoMobile.page.keyWord.step.AbstractKeyWordStep#_executeStep(com
     * .perfectoMobile.page.Page, org.openqa.selenium.WebDriver, java.util.Map,
     * java.util.Map)
     */
    @Override
    public boolean _executeStep( Page pageObject, WebDriver webDriver, Map<String, Object> contextMap, Map<String, PageData> dataMap, Map<String, Page> pageMap, SuiteContainer sC, ExecutionContextTest executionContext ) throws Exception
    {
        if ( log.isDebugEnabled() )
            log.debug( "Execution Function " + getName() );

        if ( getName().toUpperCase().startsWith( SwitchType.SWITCH_TO_ELEMENT.name ) )
        {
            Element currentElement = getElement( pageObject, contextMap, webDriver, dataMap, getName().split( "\\." )[1] );
            if ( currentElement == null )
            {
                log.warn( "Attempting to switch to frame identified by " + getName() + " that does not exist" );
                return false;
            }

            WebElement nativeElement = (WebElement) currentElement.getNative();
            if ( nativeElement instanceof MorelandWebElement )
                nativeElement = ((MorelandWebElement) nativeElement).getWebElement();
            webDriver.switchTo().frame( nativeElement );
        }
        else
        {
            switch ( SwitchType.valueOf( getName().toUpperCase() ) )
            {
                case SWITCH_BY_TITLE:
                    return verifySwitchWindow( webDriver, getName(), getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                case SWITCH_BY_URL:
                    return verifySwitchWindow( webDriver, getName(), getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );

                case SWITCH_NAMED_FRAME:
                    webDriver.switchTo().frame( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                    break;
                case SWITCH_INDEX:
                    webDriver.switchTo().frame( Integer.parseInt( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" ) );
                    break;
                case PARENT_FRAME:
                    webDriver.switchTo().parentFrame();
                    break;
                case DEFAULT_FRAME:
                    webDriver.switchTo().defaultContent();
                    break;
                case CLOSE_WINDOW:
                    webDriver.close();
                    break;
                case NAVIGATE:
                    webDriver.navigate().to( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                    break;

                case MAXIMIZE:
                    webDriver.manage().window().maximize();
                    break;
                case GET_TITLE:
                    String pageTitle = webDriver.getTitle();
                    if ( getParameterList().size() > 1 )
                    {
                        String compareTo = getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "";
                        if ( !compareTo.equals( pageTitle ) )
                        {
                            throw new ScriptException( "Expected Title of [" + compareTo + "] but received [" + pageTitle + "]" );
                        }
                    }

                    if ( !validateData( pageTitle ) )
                        throw new ScriptException( "GET_TITLE Expected a format of [" + getValidationType() + "(" + getValidation() + ") for [" + pageTitle + "]" );

                    if ( getContext() != null && !getContext().trim().isEmpty() )
                        contextMap.put( getContext(), pageTitle );

                    break;

                case GET_URL:
                    String currentUrl = webDriver.getCurrentUrl();
                    if ( getParameterList().size() > 1 )
                    {
                        String compareTo = getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "";
                        if ( !compareTo.equals( currentUrl ) )
                        {
                            throw new ScriptException( "Expected Title of [" + compareTo + "] but received [" + currentUrl + "]" );
                        }
                    }

                    if ( !validateData( currentUrl ) )
                        throw new ScriptException( "GET_URL Expected a format of [" + getValidationType() + "(" + getValidation() + ") for [" + currentUrl + "]" );

                    if ( getContext() != null && !getContext().trim().isEmpty() )
                        contextMap.put( getContext(), currentUrl );

                    break;

                case BACK:
                    webDriver.navigate().back();
                    break;
                case FORWARD:
                    webDriver.navigate().forward();
                    break;
                case REFRESH:
                    webDriver.navigate().refresh();
                    break;
                case SWITCH_WIN_INDEX:
                    int i = 0;
                    int index = 0;
                    if ( getParameterList().size() < 2 )
                        index = 0;
                    else
                        index = Integer.valueOf( getParameterValue( getParameterList().get( 1 ), contextMap, dataMap ) + "" );

                    for ( String handle : webDriver.getWindowHandles() )
                    {
                        if ( i == index )
                        {
                            webDriver.switchTo().window( handle );
                            break;
                        }
                        i += 1;
                    }
                    break;
                case ADD_COOKIE:
                    Cookie addCookie = new Cookie( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "", getParameterValue( getParameterList().get( 1 ), contextMap, dataMap ) + "" );
                    if ( webDriver instanceof RemoteWebDriver )
                        ((RemoteWebDriver) webDriver).manage().addCookie( addCookie );
                    else if ( webDriver instanceof NativeDriverProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver )
                    {
                        ((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().addCookie( addCookie );
                    }

                    break;

                case DELETE_COOKIE:

                    if ( getParameterList().size() < 1 )
                    {
                        if ( webDriver instanceof RemoteWebDriver )
                            ((RemoteWebDriver) webDriver).manage().deleteAllCookies();
                        else if ( webDriver instanceof NativeDriverProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver )
                        {
                            ((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().deleteAllCookies();
                        }
                    }
                    else
                    {
                        if ( webDriver instanceof RemoteWebDriver )
                            ((RemoteWebDriver) webDriver).manage().deleteCookieNamed( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                        else if ( webDriver instanceof NativeDriverProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver )
                        {
                            ((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().deleteCookieNamed( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                        }
                    }
                    break;

                case GET_COOKIE:

                    if ( getParameterList().size() < 1 )
                    {
                        Set<Cookie> cookieSet = null;
                        if ( webDriver instanceof RemoteWebDriver )
                            cookieSet = ((RemoteWebDriver) webDriver).manage().getCookies();
                        else if ( webDriver instanceof NativeDriverProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver )
                        {
                            cookieSet = ((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().getCookies();
                        }

                        StringBuilder buffer = new StringBuilder();
                        for ( Cookie cookie : cookieSet )
                        {
                            buffer.append( cookie.getName() + ":" + cookie.getValue() ).append( ";" );
                            if ( getContext() != null )
                            {
                                contextMap.put( getContext() + "_" + cookie.getName(), cookie.getValue() );
                            }
                        }
                        String cookieValue = buffer.toString();
                        if ( !validateData( cookieValue ) )
                        {
                            throw new IllegalStateException( "Get cookie Expected a format of [" + getValidationType() + "(" + getValidation() + ") for [" + cookieValue + "]" );
                        }

                        if ( getContext() != null )
                        {
                            contextMap.put( getContext(), cookieValue );
                        }

                    }
                    else
                    {
                        Cookie getCookie = null;
                        if ( webDriver instanceof RemoteWebDriver )
                            getCookie = ((RemoteWebDriver) webDriver).manage().getCookieNamed( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );
                        else if ( webDriver instanceof NativeDriverProvider && ((NativeDriverProvider) webDriver).getNativeDriver() instanceof RemoteWebDriver )
                            getCookie = ((RemoteWebDriver) ((NativeDriverProvider) webDriver).getNativeDriver()).manage().getCookieNamed( getParameterValue( getParameterList().get( 0 ), contextMap, dataMap ) + "" );

                        if ( !validateData( getCookie.getValue() ) )
                        {
                            throw new IllegalStateException( "Get cookie Expected a format of [" + getValidationType() + "(" + getValidation() + ") for [" + getCookie.getValue() + "]" );
                        }

                        if ( getContext() != null )
                        {
                            contextMap.put( getContext(), getCookie.getValue() );
                        }
                    }

                    break;

                default:

                    throw new ScriptConfigurationException( "Unknown Window Operation Type " + getName() );
            }
        }

        return true;
    }

    /**
     * Verify switch window.
     *
     * @param webDriver
     *            the web driver
     * @param byTitleOrUrl
     *            the by title or url
     * @param winExpValue
     *            the win exp value
     * @return true, if successful
     */
    private boolean verifySwitchWindow( WebDriver webDriver, String byTitleOrUrl, String winExpValue )
    {

        boolean bSwitchWindow = false;
        String winActValue = "";
        Set<String> availableWindows = webDriver.getWindowHandles();

        if ( !availableWindows.isEmpty() )
        {
            for ( String windowId : availableWindows )
            {
                if ( byTitleOrUrl.equalsIgnoreCase( "SWITCH_BY_TITLE" ) )
                {
                    winActValue = webDriver.switchTo().window( windowId ).getTitle().trim().toLowerCase();
                }
                else
                {
                    winActValue = webDriver.switchTo().window( windowId ).getCurrentUrl().trim().toLowerCase();
                }

                winExpValue = winExpValue.trim().toLowerCase();

                if ( winActValue.contains( winExpValue ) )
                {
                    bSwitchWindow = true;
                    break;
                }
            }
        }

        return bSwitchWindow;
    }

}
