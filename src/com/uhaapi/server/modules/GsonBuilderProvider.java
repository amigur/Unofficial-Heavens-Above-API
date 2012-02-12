package com.uhaapi.server.modules;

import java.util.Date;

import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uhaapi.server.accepts.PrettyPrinting;
import com.uhaapi.server.util.DateAdapter;

public class GsonBuilderProvider implements Provider<GsonBuilder> {
	private final Boolean prettyPrinting;
	
	@Inject
	public GsonBuilderProvider(@PrettyPrinting Boolean prettyPrinting) {
		this.prettyPrinting = prettyPrinting;
	}

	@Override
	public GsonBuilder get() {
		GsonBuilder gsonBuilder = new GsonBuilder()
			.registerTypeAdapter(Date.class, new DateAdapter())
			;

		if(prettyPrinting) {
			gsonBuilder = gsonBuilder.setPrettyPrinting();
		}

		return gsonBuilder;
	}
}
