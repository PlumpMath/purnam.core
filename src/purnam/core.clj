(ns purnam.core
  (:require [purnam.common :refer :all]
            [purnam.common.parse :refer [split-syms parse-var parse-sub-exp]]
            [purnam.common.expand :refer [expand expand-fn expand-sym]]
            [purnam.common.scope :refer [change-roots-map]]
            [purnam.core.fn :refer [construct-fn]]
            [purnam.core.var :refer [make-var make-js-array]]
            [purnam.core.raw :refer [walk-raw]]))

(add-symbols purnam.common/*exclude-expansion*
             '[purnam.core ? ?> ! !> f.n def.n do.n obj arr def*]
             '? '?> '! '!> 'f.n 'def.n 'do.n 'obj 'arr 'def*)

(defmacro ? [sym]
  (expand-sym sym))

(defmacro ?> [& args]
  (apply list (map expand args)))

(defmacro ! [sym & [val]]
  (let [[var & ks] (split-syms sym)]
    (list 'purnam.common/aset-in (parse-var var)
          (vec (map parse-sub-exp ks))
          (expand val))))

(defmacro !> [sym & args] (expand-fn sym args))

(defmacro f.n [& body] (construct-fn identity body))

(defmacro def.n [sym & body]
  (list 'def sym (construct-fn identity body)))

(defmacro do.n [& body]
  `(do ~@(expand body)))

(defmacro obj [& args]
  (let [m (apply hash-map args)]
    (expand (make-var m))))

(defmacro arr [& args]
  (expand (make-js-array args)))

(defmacro def* [name form]
  `(def ~name
        ~(expand (walk-raw form))))

(defmacro range* [n]
  `(array ~@(range n)))
