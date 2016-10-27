/***************************************************************************************************
 * MIT License
 *
 * Copyright (c) 2016 Rafael Luis Ibasco
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 **************************************************************************************************/

package com.ribasco.rglib.protocols.valve.steam.api.userstats;

import com.ribasco.rglib.protocols.valve.steam.SteamApiConstants;
import com.ribasco.rglib.protocols.valve.steam.SteamWebApiRequest;
import org.asynchttpclient.RequestBuilder;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 * Created by raffy on 10/27/2016.
 */
public class GetPlayerAchievements extends SteamWebApiRequest {

    private long steamId;
    private int appId;
    private String language = "en";

    public GetPlayerAchievements(int apiVersion, long steamId, int appId) {
        this(apiVersion, steamId, appId, null);
    }

    public GetPlayerAchievements(int apiVersion, long steamId, int appId, String language) {
        super(SteamApiConstants.STEAM_USER_STATS, "GetPlayerAchievements", apiVersion);
        this.steamId = steamId;
        this.appId = appId;
        this.language = defaultIfNull(language, "en");
    }

    @Override
    protected void buildRequest(RequestBuilder requestBuilder) {
        addParam("steamid", this.steamId);
        addParam("appid", this.appId);
        addParam("l", this.language);
    }

    public long getSteamId() {
        return steamId;
    }

    public void setSteamId(long steamId) {
        this.steamId = steamId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
