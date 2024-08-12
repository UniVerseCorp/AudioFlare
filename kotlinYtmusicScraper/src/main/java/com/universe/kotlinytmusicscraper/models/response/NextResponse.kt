package com.universe.kotlinytmusicscraper.models.response

import com.universe.kotlinytmusicscraper.models.NavigationEndpoint
import com.universe.kotlinytmusicscraper.models.PlaylistPanelRenderer
import com.universe.kotlinytmusicscraper.models.Tabs
import com.universe.kotlinytmusicscraper.models.youtube.data.YouTubeDataPage
import kotlinx.serialization.Serializable

@Serializable
data class NextResponse(
    val contents: Contents,
    val continuationContents: ContinuationContents?,
    val currentVideoEndpoint: NavigationEndpoint?,
) {
    @Serializable
    data class Contents(
        val singleColumnMusicWatchNextResultsRenderer: SingleColumnMusicWatchNextResultsRenderer?,
        val twoColumnWatchNextResults: YouTubeDataPage.Contents.TwoColumnWatchNextResults?
    ) {
        @Serializable
        data class SingleColumnMusicWatchNextResultsRenderer(
            val tabbedRenderer: TabbedRenderer,
        ) {
            @Serializable
            data class TabbedRenderer(
                val watchNextTabbedResultsRenderer: WatchNextTabbedResultsRenderer,
            ) {
                @Serializable
                data class WatchNextTabbedResultsRenderer(
                    val tabs: List<Tabs.Tab>,
                )
            }
        }
    }

    @Serializable
    data class ContinuationContents(
        val playlistPanelContinuation: PlaylistPanelRenderer?,
        val sectionListContinuation: BrowseResponse.ContinuationContents.SectionListContinuation?,
        val musicPlaylistShelfContinuation: BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation?
    )
}
