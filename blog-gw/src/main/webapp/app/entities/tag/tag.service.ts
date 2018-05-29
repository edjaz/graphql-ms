import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Tag } from './tag.model';
import { createRequestOption } from '../../shared';

import gql from 'graphql-tag';
import {Apollo} from 'apollo-angular';
import { ApolloClient, WatchQueryOptions, MutationOptions, ApolloQueryResult, SubscriptionOptions, ApolloClientOptions } from 'apollo-client';
import { FetchResult } from 'apollo-link';

const query = gql`
                query {
                    allTags {
                        id
                        name
                    }
                }
    `;


const find =  gql`
                query tag ($id : String){
                    tag(id : $id ) {
                        id
                        name
                    }
                }
    `;


const save =  gql`
                mutation saveTag ($tag : TagVM){
                    saveTag(tag : $tag ) {
                        id
                        name
                    }
                }
    `;


export type EntityResponseType = HttpResponse<Tag>;

@Injectable()
export class TagService {

    private resourceUrl =  SERVER_API_URL + 'tag/api/tags';

    constructor(private http: HttpClient, private apollo: Apollo) { }

    create(tag: Tag): Observable<FetchResult<any>> {
        const q:MutationOptions = {
            mutation : save,
            variables: {
                tag: tag,
            }
        };
        return this.apollo.mutate(q);


/*        const copy = this.convert(tag);
        return this.http.post<Tag>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));*/
    }

    update(tag: Tag): Observable<FetchResult<any>> {
        const q:MutationOptions = {
            mutation : save,
            variables:{
                tag : tag
            }
        };
        return this.apollo.mutate(q);

        /*const copy = this.convert(tag);
        return this.http.put<Tag>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));*/
    }

    find(id: number): Observable<ApolloQueryResult<any>> {
        const q:WatchQueryOptions = {
            query : find,
            variables:{
                id : id,
            },
            fetchPolicy : "no-cache"
        };
        return this.apollo.query<any>(q);
    }


    query(req?: any): Observable<ApolloQueryResult<any>> {
        const q:WatchQueryOptions = {
            query : query,
            fetchPolicy : "no-cache"
        };
        return this.apollo.query<any>(q);
/*
        const options = createRequestOption(req);
        return this.http.get<Tag[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<Tag[]>) => this.convertArrayResponse(res));*/
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Tag = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Tag[]>): HttpResponse<Tag[]> {
        const jsonResponse: Tag[] = res.body;
        const body: Tag[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Tag.
     */
    private convertItemFromServer(tag: Tag): Tag {
        const copy: Tag = Object.assign({}, tag);
        return copy;
    }

    /**
     * Convert a Tag to a JSON which can be sent to the server.
     */
    private convert(tag: Tag): Tag {
        const copy: Tag = Object.assign({}, tag);
        return copy;
    }
}
