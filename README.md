# wikifollow
Wikidata follow property automation for numbered content

If wikidata has part property has numbered  labels, this java program creates follows and follewed by properties (and missing labels...)

The input is result of the "SELECT ?item ?itemLabel  WHERE {
  ?item wdt:P361 wd:Q6789860.
  SERVICE wikibase:label { bd:serviceParam wikibase:language "en". }
}" query in https://query.wikidata.org/#

The output can be batch prosessed by https://tools.wmflabs.org/wikidata-todo/quick_statements.php

Pekka Järveläinen
