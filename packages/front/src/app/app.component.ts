import { Component } from '@angular/core';
import { map, Observable } from "rxjs";
import {
  CreateAssetGQL,
  GetDatacenterGQL,
  GetDatacenterQuery,
  GetDatacenterQueryVariables,
  Rack
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

    this.assetQueryRef = this.getAssets.watch();
    this.datacenter$ = this.assetQueryRef.valueChanges.pipe(
      map((response) => response.data.datacenter)
    )
  }

  addAsset($event: any, rack: Rack) {
    this.createAsset.mutate({
      name: $event.target.value,
      parentId: rack.id,
    }).subscribe(async () => {
      await this.assetQueryRef.refetch();
    })
  }
}
