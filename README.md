# binit
cljs library to wrap horrible in-browser js binary fetching and convert to base64

Purpose: 

fetching a binary file and sending it somewhere else from in-browser javascript is [horrendously convoluted](https://github.com/paultopia/scrape-pdf), involving diddling with the properties of http requests, instantiating seemingly random objects, asking the browser to pretend that a sequence of ints was intended to be unicode and calling string methods on it, and other bizarre Fear and Loathing in Javascript kinds of nonsense.  

It, like most javascript things, makes me sad.  But clojure makes me happy, and if you're looking at this it probably makes you happy too.  So let's just do that. 

## Usage: 

`(fetch-binary url)` returns a base64 enoded string of the binary at url. 

That's it.  That's all it does.
