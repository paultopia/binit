# binit
cljs library to wrap horrible in-browser js binary fetching and convert to base64

Purpose: 

Fetching a binary file and doing something to it from in-browser javascript is [horrendously convoluted](https://github.com/paultopia/scrape-pdf), involving diddling with the properties of http requests, instantiating seemingly random objects, asking the browser to pretend that a sequence of ints was intended to be unicode and calling string methods on it, and other bizarre Fear and Loathing in Javascript kinds of nonsense.

It, like most Javascript things, makes me sad.  But Clojure makes me happy, and if you're looking at this it probably makes you happy too.  So let's just do the whole thing in Clojurescript like a rational person.

## Usage: 

get the library and such like normal. You also need core.async. 

    [paulitheism/binit "0.0.1-SNAPSHOT"]

**only not just yet because I should probably test this at least a little before I put it up on clojars.**

and then

    (require '[binit.core :refer [fetch-binary]])

You've got some binary file sitting on a server somewhere that you want to do something side-effectey with (like send to another server, fire off in a message in a clojurescript extension, etc.) without going through Javascript encoding hell.

`(fetch-binary func url)` asynchronously fetches the binary file at url, converts it to base64, and calls func on it. 

That's it.  That's all it does.
