package com.luismunyoz.iceman.webservices;

import com.luismunyoz.iceman.model.Character;
import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.webservices.responses.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Luism on 02/04/2017.
 */

public interface IcemanService {

    @GET("/v1/public/characters/{id}")
    Call<BaseResponse<Character>> getCharacter(@Path("id") String id);

    @GET("/v1/public/characters/{id}/comics")
    Call<BaseResponse<Comic>> getComicsByCharacter(@Path("id") String characterId);
}
