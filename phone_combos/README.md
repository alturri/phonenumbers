
Note:  the frontend was written in ReactJS.  Once ReactJS has been setup locally
       which will open up a page in your default browser at http://localhost:3000,
       from where you'll be able to visualize & test the application (frontend + backend).

1)  Ideally, one would give the user tbe option of specifying, within the GUI,
    how many elements to display within a single web page, as is commonly seen
    on the Web, rather than hardcoding such a number, which is currently set at 40 (both in 
    the FE & the BE, of course).

2)  Similarly, the controller in the real world would be made threadsafe and be 
    able to handle multiple requests at the same time, from multiple users.

3)  Something more important than the first two points:  namely, the specs called
    for a space-separated phone number as input and a corresponding space-separated
    list of phone numbers as output.  

4)  If time permitted, one would have removed the code duplication present in the frontend's
    'handleSubmit' & 'links' functions.

5)  Something else missing:  integration tests for the controller on the backend.

Note:  I did elect to put each page link on a separate line, as in certain cases there may be
       many combinations and I, for one, found it more user-friendly to have a user scan through
       multiple lines rather than look for a specific link within a single, possibly very wide line.