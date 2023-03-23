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
  parent: Location;
};

export type Datacenter = {
  __typename?: 'Datacenter';
  id: Scalars['ID'];
  name: Scalars['String'];
  rooms: Array<Maybe<Room>>;
};

export type Location = Datacenter | Rack | Room | Row;

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
  outlets: Array<PduOutlet>;
  parent: Location;
};

export type PduOutlet = {
  __typename?: 'PduOutlet';
  id: Scalars['ID'];
  label?: Maybe<Scalars['String']>;
  plugType: PduOutletType;
};

export enum PduOutletType {
  C13 = 'C13',
  C19 = 'C19',
  C39 = 'C39',
  Other = 'OTHER'
}

export type Query = {
  __typename?: 'Query';
  asset: Asset;
  assets: Array<Maybe<Asset>>;
  datacenter: Datacenter;
  locations: Array<Maybe<Location>>;
  rack: Rack;
  racks: Array<Maybe<Rack>>;
  room: Room;
  rooms: Array<Maybe<Room>>;
  row: Row;
  rows: Array<Maybe<Row>>;
};


export type QueryAssetArgs = {
  id: Scalars['ID'];
};


export type QueryRackArgs = {
  id: Scalars['ID'];
};


export type QueryRoomArgs = {
  id: Scalars['ID'];
};


export type QueryRowArgs = {
  id: Scalars['ID'];
};

export type Rack = {
  __typename?: 'Rack';
  assets: Array<Maybe<Asset>>;
  id: Scalars['ID'];
  name: Scalars['String'];
  parent: Datacenter;
};

export type Room = {
  __typename?: 'Room';
  id: Scalars['ID'];
  name: Scalars['String'];
  parent: Datacenter;
  rows: Array<Maybe<Row>>;
};

export type Row = {
  __typename?: 'Row';
  id: Scalars['ID'];
  name: Scalars['String'];
  parent: Datacenter;
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
  parent: Location;
};

export type GetDatacenterQueryVariables = Exact<{ [key: string]: never; }>;


export type GetDatacenterQuery = { __typename?: 'Query', datacenter: { __typename?: 'Datacenter', id: string, name: string, rooms: Array<{ __typename?: 'Room', id: string, name: string, rows: Array<{ __typename?: 'Row', id: string, name: string, racks: Array<{ __typename?: 'Rack', id: string, name: string, assets: Array<{ __typename?: 'Pdu', outletCount: number, id: string, name: string } | { __typename?: 'Ups', batteryPercentage: number, id: string, name: string } | null> } | null> } | null> } | null> } };

export type CreateAssetMutationVariables = Exact<{
  name: Scalars['String'];
  parentId: Scalars['String'];
}>;


export type CreateAssetMutation = { __typename?: 'Mutation', createAsset: { __typename?: 'Pdu', id: string, name: string, parent: { __typename?: 'Datacenter' } | { __typename?: 'Rack', id: string, assets: Array<{ __typename?: 'Pdu', id: string } | { __typename?: 'Ups', id: string } | null> } | { __typename?: 'Room' } | { __typename?: 'Row' } } | { __typename?: 'Ups', id: string, name: string, parent: { __typename?: 'Datacenter' } | { __typename?: 'Rack', id: string, assets: Array<{ __typename?: 'Pdu', id: string } | { __typename?: 'Ups', id: string } | null> } | { __typename?: 'Room' } | { __typename?: 'Row' } } };

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
    name
    parent {
      ... on Rack {
        id
        assets {
          id
        }
      }
    }
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
