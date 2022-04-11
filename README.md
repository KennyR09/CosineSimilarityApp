# CosineSimilarityApp

Cosine Similarity App

This application calculates the similarity between a main document and other documents. 
It calculates the document character frequency of all documents via a HashMap with an another document . 
The results create a tf-idf vector for each document. (i.e. term frequency–inverse document frequency = term frequency * inverse document frequency).
Code snippets of this can be seen below:
term frequency–inverse document frequency = 
 for (String item : intersection) {
            dotProduct += s.get(item) * q.get(item);
        }

term frequency =
        for (String k : s.keySet()) {
            subject += Math.pow(s.get(k), 2);
        }

inverse document frequency = 
        for (String k : q.keySet()) {
            query += Math.pow(q.get(k), 2);
        }

term frequency–inverse document frequency = term frequency * inverse document frequency=
        return dotProduct / Math.sqrt(subject * query);
    }


After that, the cosine similarity between two documents' tf-idf vectors are calculated, in order to compare the two documents and printed to the CMD line.

Steps:
To get the similarity the following steps are executed:

1)Parsing the main document (the Subject) and an other documents (the Quary).

2)Calculating the cosine similarities between the main document (the Subject) and an other documents (the Quary).

3)Outputting the Similarity results to teh CMD line.




Citation
https://gist.github.com/vamsigp/e2c7857a9aae4b653778

https://sites.google.com/site/nirajatweb/home/technical_and_coding_stuff/cosine_similarity

https://blog.nishtahir.com/fuzzy-string-matching-using-cosine-similarity/

https://github.com/mouryallagadda/DocSimilaritySearch

https://github.com/nickitaliano/Cosine-Similarity-Algorithm

https://en.wikipedia.org/wiki/Tf%E2%80%93idf
