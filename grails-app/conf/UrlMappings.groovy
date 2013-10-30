class UrlMappings {

	static mappings = {
        //index mappings
		"/"(controller:"index")
		"/home"(controller:"index")
		"/about"(controller:"index", action:"about")

        //lab mappings
        "/lab"(controller:"lab")
	}
}
