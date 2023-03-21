import { gql } from 'apollo-angular';
import { Injectable } from '@angular/core';
import * as Apollo from 'apollo-angular';
export type Maybe<T> = T | null;
export type InputMaybe<T> = Maybe<T>;
export type Exact<T extends { [key: string]: unknown }> = { [K in keyof T]: T[K] };
export type MakeOptional<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]?: Maybe<T[SubKey]> };
export type MakeMaybe<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]: Maybe<T[SubKey]> };
/** All built-in and custom scalars, mapped to their actual values */
export type Scalars = {
  ID: string;
  String: string;
  Boolean: boolean;
  Int: number;
  Float: number;
};

export type Asset = {
  id: Scalars['ID'];
  name: Scalars['String'];
};

export type Datacenter = {
  __typename?: 'Datacenter';
  id: Scalars['ID'];
  name: Scalars['String'];
  rooms: Array<Maybe<Room>>;
};

export type Mutation = {
  __typename?: 'Mutation';
  createAsset: Asset;
};


export type MutationCreateAssetArgs = {
  name: Scalars['String'];
  parentId: Scalars['String'];
};

export type Pdu = Asset & {
  __typename?: 'Pdu';
  id: Scalars['ID'];
  name: Scalars['String'];
  outletCount: Scalars['Int'];
};

export type Query = {
  __typename?: 'Query';
  asset: Asset;
  assets: Array<Maybe<Asset>>;
  datacenter: Datacenter;
};


export type QueryAssetArgs = {
  id: Scalars['ID'];
};

export type Rack = {
  __typename?: 'Rack';
  assets: Array<Maybe<Asset>>;
  id: Scalars['ID'];
  name: Scalars['String'];
};

export type Room = {
  __typename?: 'Room';
  id: Scalars['ID'];
  name: Scalars['String'];
  rows: Array<Maybe<Row>>;
};

export type Row = {
  __typename?: 'Row';
  id: Scalars['ID'];
  name: Scalars['String'];
  racks: Array<Maybe<Rack>>;
};

export type Schema = {
  __typename?: 'Schema';
  mutation: Mutation;
  query: Query;
};

export type Ups = Asset & {
  __typename?: 'Ups';
  batteryPercentage: Scalars['Int'];
  id: Scalars['ID'];
  name: Scalars['String'];
};

export type GetDatacenterQueryVariables = Exact<{ [key: string]: never; }>;


export type GetDatacenterQuery = { __typename?: 'Query', datacenter: { __typename?: 'Datacenter', id: string, name: string, rooms: Array<{ __typename?: 'Room', id: string, name: string, rows: Array<{ __typename?: 'Row', id: string, name: string, racks: Array<{ __typename?: 'Rack', id: string, name: string, assets: Array<{ __typename?: 'Pdu', outletCount: number, id: string, name: string } | { __typename?: 'Ups', batteryPercentage: number, id: string, name: string } | null> } | null> } | null> } | null> } };

export type CreateAssetMutationVariables = Exact<{
  name: Scalars['String'];
  parentId: Scalars['String'];
}>;


export type CreateAssetMutation = { __typename?: 'Mutation', createAsset: { __typename?: 'Pdu', id: string } | { __typename?: 'Ups', id: string } };

export const GetDatacenterDocument = gql`
    query GetDatacenter {
  datacenter {
    id
    name
    rooms {
      id
      name
      rows {
        id
        name
        racks {
          id
          name
          assets {
            id
            name
            ... on Ups {
              batteryPercentage
            }
            ... on Pdu {
              outletCount
            }
          }
        }
      }
    }
  }
}
    `;

  @Injectable({
    providedIn: 'root'
  })
  export class GetDatacenterGQL extends Apollo.Query<GetDatacenterQuery, GetDatacenterQueryVariables> {
    override document = GetDatacenterDocument;

    constructor(apollo: Apollo.Apollo) {
      super(apollo);
    }
  }
export const CreateAssetDocument = gql`
    mutation CreateAsset($name: String!, $parentId: String!) {
  createAsset(name: $name, parentId: $parentId) {
    id
  }
}
    `;

  @Injectable({
    providedIn: 'root'
  })
  export class CreateAssetGQL extends Apollo.Mutation<CreateAssetMutation, CreateAssetMutationVariables> {
    override document = CreateAssetDocument;

    constructor(apollo: Apollo.Apollo) {
      super(apollo);
    }
  }
