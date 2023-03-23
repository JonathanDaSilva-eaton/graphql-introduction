import { Component } from '@angular/core';
import { firstValueFrom, map, Observable } from "rxjs";
import {
  CreateAssetGQL,
  GetDatacenterGQL,
  GetDatacenterQuery,
  GetDatacenterQueryVariables,
  Rack,
} from "../generated/graphql";
import { QueryRef } from "apollo-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  protected datacenter$: Observable<any>;
  protected assetQueryRef: QueryRef<GetDatacenterQuery, GetDatacenterQueryVariables>;

  public constructor(
    private getAssets: GetDatacenterGQL,
    private createAsset: CreateAssetGQL,
  ) {

    this.assetQueryRef = this.getAssets.watch({}, {
      fetchPolicy: "cache-first",
      initialFetchPolicy: "network-only",
      nextFetchPolicy: "cache-only",
    });
    this.datacenter$ = this.assetQueryRef.valueChanges.pipe(
      map((response) => response.data.datacenter)
    )
  }

  async addAsset($event: any, rack: Rack) {
    await firstValueFrom(this.createAsset.mutate({
      name: $event.target.value,
      parentId: rack.id,
    }, {} ));
    $event.target.value = '';
  }

  public trackById(index: number, element: { id: string }) {
    return element.id;
  }
}
