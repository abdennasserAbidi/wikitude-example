var World = {
	loaded: false,

	init: function initFn() {
		/* Disable all sensors in "IR-only" Worlds to save performance. If the property is set to true, any geo-related components (such as GeoObjects and ActionRanges) are active. If the property is set to false, any geo-related components will not be visible on the screen, and triggers will not fire.*/
		AR.context.services.sensors = false;
		this.createOverlays();
	},
       
        // button function
        createWwwButton: function createWwwButtonFn(url, size, options) {
                options.onClick = function() {
                            AR.context.openInBrowser(url);
                                };
                    return new AR.ImageDrawable(this.imgButton, size, options);
        },

        // overlay function
	createOverlays: function createOverlaysFn() {
		// Initialize Tracker
		this.tracker = new AR.Tracker("assets/gdgdevfest.wtc", {
			onLoaded: this.worldLoaded
		});

		// For the button
                this.imgButton = new AR.ImageResource("assets/button.png");
                var pageOneButton = this.createWwwButton("http://www.iesgrancapitan.org/portal/", 0.5, {
                        offsetX: -0.25,
                        offsetY: 0.75
                });

                // For the TRACKABLE
		var imgOne = new AR.ImageResource("assets/fuckyeah.jpg");
		var overlayOne = new AR.ImageDrawable(imgOne, 1, {
			offsetX: -0.15,
			offsetY: 0
		});
		var pageOne = new AR.Trackable2DObject(this.tracker, "gdgdevfest", {
			drawables: {
				cam: [pageOneButton, overlayOne]
			}
		});
	},

	worldLoaded: function worldLoadedFn() {
		var cssDivLeft = " style='display: table-cell;vertical-align: middle; text-align: right; width: 50%; padding-right: 15px;'";
		var cssDivRight = " style='display: table-cell;vertical-align: middle; text-align: left;'";
		document.getElementById('loadingMessage').innerHTML =
		"<div" + cssDivLeft + ">Scan Target &#35;1 (GDG DevFest Sur):</div>" +
			"<div" + cssDivRight + "><img src='assets/gdgdevfestmini.jpg'></img></div>";
	}
};

World.init();
