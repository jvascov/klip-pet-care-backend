package com.klip.petcare.util;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;


public class CollectionValid {

	public static Boolean validOpt(Optional<?> opt) {
		return (!(isNull(opt) || !opt.isPresent()));
	}

	public static Boolean isContent(List<?> lst) {
		return (!(isNull(lst) || lst.isEmpty()));

	}

}
