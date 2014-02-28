(ns midje-doc.purnam-core.guide)

[[:chapter {:title "Introduction"}]]

"[purnam.core](https://www.github.com/purnam/purnam.core), along [purnam.test](https://www.github.com/purnam/purnam.test) and [purnam.native](https://www.github.com/purnam/purnam.native) form the nucleus of the [purnam](https://www.github.com/purnam/purnam) extensions suite - designed to provide better clojurescript/javascript interop.
"

[[:chapter {:title "Installation"}]]

"To use just the test functionality, add to `project.clj` dependencies:

  `[im.chit/purnam.core` \"`{{PROJECT.version}}`\"`]` 

The library is also included when `[im.chit/purnam` \"`{{PROJECT.version}}`\"`]` is used."
               
[[:chapter {:title "API" :tag "purnam-core"}]]

[[:file {:src "test/cljs/midje_doc/purnam_core/api.cljs"}]]