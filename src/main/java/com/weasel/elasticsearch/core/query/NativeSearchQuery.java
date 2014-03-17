/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weasel.elasticsearch.core.query;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.facet.FacetBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;

/**
 * NativeSearchQuery
 * 
 * @author Rizwan Idrees
 * @author Mohsin Husen
 * @author Artur Konczak
 * @author Dylan
 */
public class NativeSearchQuery  extends AbstractQuery implements SearchQuery {

	private QueryBuilder query;
	private FilterBuilder filter;
	private List<SortBuilder> sorts;
    private List<FacetBuilder> facets;
    private HighlightBuilder.Field[] highlightFields;


    public NativeSearchQuery(QueryBuilder query) {
        this.query = query;
    }

    public NativeSearchQuery(QueryBuilder query, FilterBuilder filter) {
        this.query = query;
        this.filter = filter;
    }

	public NativeSearchQuery(QueryBuilder query, FilterBuilder filter, List<SortBuilder> sort) {
		this.query = query;
		this.filter = filter;
		this.sorts = sort;
	}

    public NativeSearchQuery(QueryBuilder query, FilterBuilder filter, List<SortBuilder> sort, HighlightBuilder.Field[] highlightFields) {
        this.query = query;
        this.filter = filter;
        this.sorts = sort;
        this.highlightFields = highlightFields;
    }

	public QueryBuilder getQuery() {
		return query;
	}

	public FilterBuilder getFilter() {
		return filter;
	}

	
	@Override
    public HighlightBuilder.Field[] getHighlightFields() {
        return highlightFields;
	}

    public void addFacet(FacetBuilder facet){
        if(facets==null){
            facets = new ArrayList<FacetBuilder>();
        }
        facets.add(facet);
    }

    public void setFacets(List<FacetBuilder> facets){
        this.facets = facets;
    }

    @Override
    public List<FacetBuilder> getFacets() {
        return facets;
    }

	@Override
	public List<SortBuilder> getElasticsearchSort() {
		return sorts;
	}

}
