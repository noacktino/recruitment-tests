# Rails Test Assignment

Implement a rails app that provides a JSON interface to a mobile app.
The main task of this component is to fetch data from http://openweathermap.org/api and pass it to the app.
You can assume that the app is providing you with the coordinates in the correct way (as shown in this cal:l http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139). So the arguments are passed as a query parameter for lat and lon.

The format of the result JSON looks like this:

```{  
   "coord":{  
      "lon":139,
      "lat":35
   },
   "sys":{  
      "type":1,
      "id":7616,
      "message":1.6915,
      "country":"JP",
      "sunrise":1433187053,
      "sunset":1433238782
   },
   "weather":[  
      {  
         "id":803,
         "main":"Clouds",
         "description":"broken clouds",
         "icon":"04d"
      }
   ],
   "base":"stations",
   "main":{  
      "temp":296.01,
      "pressure":1011,
      "humidity":88,
      "temp_min":295.15,
      "temp_max":297.15
   },
   "visibility":10000,
   "wind":{  
      "speed":6.2,
      "deg":210
   },
   "clouds":{  
      "all":75
   },
   "dt":1433237223,
   "id":1851632,
   "name":"Shuzenji",
   "cod":200
}
```

The component should persist the result in the database and pass a JSON Object back to the app that contains, the description from the weather node, the temp from the main and the speed from the wind.

The main focus of implementing this task, should be on quality of the code - so the code needs to be readable, maintable and of course stable. In the best case the code is ready to be used in production.